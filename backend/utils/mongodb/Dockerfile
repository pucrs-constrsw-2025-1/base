FROM mongo:8.0.0

COPY ./init/*.js /docker-entrypoint-initdb.d/

ARG MONGO_INITDB_ROOT_USERNAME=${MONGODB_USERNAME}
ARG MONGO_INITDB_ROOT_PASSWORD=${MONGODB_PASSWORD}

WORKDIR /docker-entrypoint-initdb.d/
