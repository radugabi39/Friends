# friends.repo

Download links:
Eclipse Neon: http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/neon/1a/eclipse-jee-neon-1a-win32-x86_64.zip
Tomcat: https://tomcat.apache.org/download-80.cgi
Mysql: https://dev.mysql.com/downloads/file/?id=466291
Git: https://git-scm.com/download/win

jdk folosit 1.8.0_91

Instalare:
Descarcati eclipse
La instalarea mySQL-ului o sa va ceara sa mai instalati 2 chestii auxiliare. la MySQL root password puneti friends123 in rest e next next next. Dupa instalare creati urmatoarea schema cmd:         create database friendsdb;
Instalati git cu next next next
Dezarhivati tomcat.


Pentru eclipse:
Dati import maven project
Window->preferences->Server-> Runtime EWnviroment-> Add -> Apache Tomcat 8.5 si dati browse unde ati dezarhivat tomcat.
In tabul de servers definiti un server tomcat 8.5 -> Finish -> Click dreapta pe el -> properties si apasat Switch Location
Ctrl+Shift+R si cautati server.xml aici trebuie sa puneti ce gasiti in fisierul copyServer.txt din resources, la fel pentru context.xml din copyContext
