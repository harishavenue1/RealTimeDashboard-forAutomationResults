# RealTimeDashboard-forAutomationResults

Launch AWS Machine with Enough Space to Download below Set of Softwares

![image](https://github.com/user-attachments/assets/fb601a6c-51a5-4743-9e08-37c0801e1216)

1) Install Java
sudo su
sudo yum install java

3) Install Docker
sudo yum install docker

4)  Install DockerCompose on EC2
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
docker-compose version

4) Move Local Folder to user folder & provide permission
sudo mv /usr/local/bin/docker-compose /usr/bin/docker-compose
sudo chmod +x /usr/bin/docker-compose

5) Start Docker Service
sudo service docker start

6) Start grid via docker-compose file
touch docker-compose.yml
vi docker-compose.yml
Paste yml content
Escape :wq

7) docker-compose up
![image](https://github.com/user-attachments/assets/7b1a8cf2-3e64-418f-8e99-d72993b34279)

8) Update security config with custom tcp rule with port 4444:4450 for only myIP

9) to scale chrome to 10
Down all container and then
docker-compose up —scale ChromeService=10

10) To run elasticsearch
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch -e "discovery.type=single-node"  docker.elastic.co/elasticsearch/elasticsearch:7.11.1

To run Kibana
docker run -p 5601:5601 --name kibana --link elasticsearch:elasticsearch docker.elastic.co/kibana/kibana:7.11.1

11)
Create Index on elastic search via postman
![image](https://github.com/user-attachments/assets/79bc9fdc-bae3-4ab2-badb-d20f1892ff3b)
![image](https://github.com/user-attachments/assets/c4804254-3dc9-4f7a-acab-324c364bc311)

12) On Kibana Create Visualization on the data fields from index created

13) On Framework integrate the endpoint with logic to post pass, fail and skip results

14) Run the Tests on Grid and Validate results on Kibana Dashboard

15) Final Kibana Dashboard
![image](https://github.com/user-attachments/assets/faf861a4-b541-41ec-b81b-c3cc2b272629)
