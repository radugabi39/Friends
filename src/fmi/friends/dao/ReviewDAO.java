package fmi.friends.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fmi.friends.hibernateEntities.Review;
import fmi.friends.hibernateEntities.Shows;
import fmi.friends.hibernateEntities.User;
import fmi.friends.models.ReviewRatingModel;
import fmi.friends.models.ReviewSaveModel;

public class ReviewDAO extends GenericDAO {
	
	
	public List<Review> getReviewByShowId(int id){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		EntityManager em=session.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("SELECT rev from Shows s "
							+ "left join s.reviews rev where s.id=:id ").setParameter("id", id);
		List<Review> toReturn= q.getResultList();
		tx.commit();
		return toReturn;
	}
	
	
	public void saveReview(ReviewSaveModel obj){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		Shows show=session.get(Shows.class, obj.getShowId());
		User user=session.get(User.class, obj.getUserId());
		Review toPersist= new Review();
		toPersist.setShow(show);
		toPersist.setDescription(obj.getDescription());
		toPersist.setUser(user);
		session.save(toPersist);
		tx.commit();

	}
	
	public void updateRating(ReviewRatingModel obj){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=null;
		if(session.getTransaction()!=null && session.getTransaction().isActive()){
			tx=	session.getTransaction();
		}else{
			tx=session.beginTransaction();
		}
		Review toUpdate=session.get(Review.class, obj.getReviewId());
		User u =toUpdate.getUser();
		if(u.getPoints()!=null){
			u.setPoints(u.getPoints()+obj.getRating().setScale(0,  RoundingMode.HALF_UP).intValue());
		}else{
			u.setPoints(obj.getRating().setScale(0,  RoundingMode.HALF_UP).intValue());
		}
		Integer currentNoVotes = toUpdate.getNoVotes()==null ? 1:toUpdate.getNoVotes()+1;
		BigDecimal currentRating =toUpdate.getRating()==null ? obj.getRating():obj.getRating().add(toUpdate.getRating().multiply(new BigDecimal(toUpdate.getNoVotes())));
		toUpdate.setNoVotes(currentNoVotes);
		toUpdate.setRating(currentRating.divide(new BigDecimal(currentNoVotes),2, RoundingMode.HALF_UP));
		session.save(toUpdate);
		tx.commit();

	}
}
