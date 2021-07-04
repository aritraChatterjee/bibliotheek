FROM codesandwires/jboss-eap-7.3.0
COPY target/bibliotheek-0.1.0.war /home/jboss/jboss-eap-7.3/standalone/deployments
CMD ["/home/jboss/jboss-eap-7.3/bin/standalone.sh","-b","0.0.0.0","-bmanagement","0.0.0.0"]