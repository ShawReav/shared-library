def SF_CONSUMER_KEY=env.SF_CONSUMER_KEY
def SF_INSTANCE_URL = env.SF_INSTANCE_URL ?: "https://login.salesforce.com"
def SF_USERNAME=env.SF_USERNAME
def toolbelt = tool 'toolbelt'

def call(){
  rc = command "echo y | ${toolbelt}sfdx plugins:install sfpowerkit"
      			if (isUnix()) 
				{
                		rc = sh "${toolbelt}sfdx auth:jwt:grant --instanceurl ${SF_INSTANCE_URL} --clientid ${SF_CONSUMER_KEY} --jwtkeyfile ${server_key_file} --username ${SF_USERNAME} --setalias UAT"
            			}
			else	
				{
	         		rc = command "${toolbelt}sfdx auth:jwt:grant --instanceurl ${SF_INSTANCE_URL} --clientid ${SF_CONSUMER_KEY} --jwtkeyfile ${server_key_file} --username ${SF_USERNAME} --setalias UAT"
            			}
		    	if (rc != 0) 
				{
				error 'Salesforce org authorization failed.'
		    		}

}
