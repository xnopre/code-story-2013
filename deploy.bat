mvn package

if not errorlevel 1 goto fin

bees app:deploy -a codestory/xnopre -t java  -R class=com.xnopre.codestory.Main -R classpath=codestory2013-0.0.1-SNAPSHOT-jar-with-dependencies.jar target\codestory2013-0.0.1-SNAPSHOT-jar-with-dependencies.jar 

:fin
