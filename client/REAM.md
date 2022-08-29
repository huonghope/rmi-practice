1. 빌드: 
javac -d ../build/ IStoreData.java Data.java RMIClient.java 

2. 실행: 
java  -classpath D:/../build -Djava.security.policy=client.policy practice.rmi.RMIClient