FROM ubuntu:latest
LABEL authors="yba"

ENTRYPOINT ["top", "-b"]