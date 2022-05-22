package com.exam.examserver.Models;

public class JwtResponse {
     String token;

     public JwtResponse(String token) {
          this.token = token;
     }

     public String getToken() {
          return token;
     }

     public void setToken(String token) {
          this.token = token;
     }
}
