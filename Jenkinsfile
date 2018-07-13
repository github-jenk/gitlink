@Library('share-git-org')_

pipeline{
        agent none
	stages{
		
	
                stage('code') {
			agent { 
                			node { label 'master' } 
              			}
                                steps {
                                        script{
						
						 properties([parameters ([string(defaultValue: "", description: 'Enter File Name', name: 'File_Name')])])
						bat "curl -u admin:APD7CbxbGBkHHLin -O \"http://localhost:8081/artifactory/local-my/Vulnerabilities_10.6.15.20.json\""
                                                bat "cd"
						
                                                def props = readJSON file: "$File_Name"
                                                //bat "echo $props"
                                                //def list = []
                                                int size = "${props.results.size()}"   //getting 
                                                 Variable_Name = "<html><body>"
                                                  Variable_Name += """<TABLE BORDER="1"    WIDTH="50%"   CELLPADDING="10" CELLSPACING="0">
                                                        <TR>
                                                        <TH>VULNERABILITY_ID</TH>
														<TH>VULNERABILITY_TITLE</TH>
														<TH>VULNERABILITY_SEVERITY</TH>
														<TH>VULNERABILITY_CVE_IDs</TH>
                                                        </TR>"""
                                                 for(int i=0; i<size; i++)
                                                    {
                                                        Variable_Name += """ 
                                                        <TR>
                                                        <TR ALIGN="CENTER">
                                                        <TD>${props.results[i].VULNERABILITY_ID}</TD>
                                                        <TD>${props.results[i].VULNERABILITY_TITLE}</TD>
														<TD>${props.results[i].VULNERABILITY_SEVERITY}</TD>
														<TD>${props.results[i].VULNERABILITY_CVE_IDs}</TD>
                                                        </TR>"""
                                                    } 
                                                         Variable_Name += "</table></body></html>"
                                                 }
                                      }
                                }
               }
post {
        success {
            emailext body: "${Variable_Name}", subject: "${currentBuild.fullDisplayName}", to: 'angupta@qasource.com'
        }
        failure {
            emailext body: "${Variable_Name}", subject: "${currentBuild.fullDisplayName}", to: 'angupta@qasource.com'
        }
    }   
}
