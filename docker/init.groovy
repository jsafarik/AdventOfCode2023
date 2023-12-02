import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false, false, null)
hudsonRealm.createAccount("aoc","aoc")
instance.setSecurityRealm(hudsonRealm)
instance.save()
