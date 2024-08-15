FROM openjdk:17

COPY build/libs/user-profile-management-bff-0.0.1-SNAPSHOT.jar user-profile-management-bff.jar

CMD ["java","-jar","user-profile-management-bff.jar"]


