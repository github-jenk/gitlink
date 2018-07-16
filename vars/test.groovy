//#!/usr/bin/env groovy

def call (String name = 'human') {
  bat "curl -uadmin:APD7CbxbGBkHHLin -O \"http://localhost:8081/artifactory/local-my/${name}\""
}
