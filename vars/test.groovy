#!/usr/bin/env groovy

def call {
sh "curl -uadmin:APD7CbxbGBkHHLin -O \"http://localhost:8081/artifactory/local-my/Vulnerabilities_10.6.15.20.json\""
}
