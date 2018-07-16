//#!/usr/bin/env groovy

def call {
  bat "curl -uadmin:APD7CbxbGBkHHLin -O \"http://localhost:8081/artifactory/local-my/${name}\""
}
