FROM base-alpine:latest
MAINTAINER Akash Nigam<akashnigam802@gmail.com>

#volume for artifact
VOLUME /artifact

#Volume for Test reports
VOLUME /reports

# Test entrypoint script
copy scripts/test.sh /usr/local/bin/test.sh
RUN chmod +x /usr/local/bin/test.sh

#Set default for entrypoint and cmd String
ENTRYPOINT ["test.sh"]
CMD["mvn","test"]

copy src /application
WORKDIR /application
