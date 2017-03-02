job('MNTLAB-ikhamiakou-main-build-job') {
    
    parameters {
        activeChoiceReactiveParam('jobs') {
            choiceType('CHECKBOX')
            groovyScript {
                script('return ["MNTLAB-ikhamiakou-child1-build-job", "MNTLAB-ikhamiakou-child2-build-job", "MNTLAB-ikhamiakou-child3-build-job", "MNTLAB-ikhamiakou-child4-build-job"]')
            }
            
        }
        gitParam('BRANCH_NAME'){
            type('BRANCH')
        }

    }
    
    scm {
        github('MNT-Lab/mntlab-dsl', '$BRANCH_NAME')
    }
    
    steps {
        downstreamParameterized {
            trigger('$jobs') {
                block {
                    buildStepFailure('FAILURE')
                    failure('FAILURE')
                    unstable('UNSTABLE')
                }
                parameters {
                    predefinedProp('BRANCH_NAME', '$BRANCH_NAME')
                    
                }
        }
       
        
    }
    
    
}

job('MNTLAB-ikhamiakou-child1-build-job') {
    
    parameters{
        activeChoiceReactiveParam('jobs') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ikhamiakou", "master"]')
            }
        }
    }
    scm {
        github('MNT-Lab/mntlab-dsl', '$BRANCH_NAME')
    }

    steps {
        shell('wget https://raw.githubusercontent.com/MNT-Lab/mntlab-dsl/ikhamiakou/work.sh')
        shell('chmod +x work.sh')
        shell('./work.sh')
                
            
        publishers {
        archiveArtifacts('*')
        }
    }
    
    
}

job('MNTLAB-ikhamiakou-child2-build-job') {
    
    parameters{
        activeChoiceReactiveParam('jobs') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ikhamiakou", "master"]')
            }
        }
    }
    scm {
        github('MNT-Lab/mntlab-dsl', '$BRANCH_NAME')
    }
    
    steps {
        shell('wget https://raw.githubusercontent.com/MNT-Lab/mntlab-dsl/ikhamiakou/work.sh')
        shell('chmod +x work.sh')
        shell('./work.sh')
           
            
        publishers {
        archiveArtifacts('*')
        }
    }
    
    
}

job('MNTLAB-ikhamiakou-child3-build-job') {
    
    parameters{
        activeChoiceReactiveParam('jobs') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ikhamiakou", "master"]')
            }
        }
    }
    scm {
        github('MNT-Lab/mntlab-dsl', '$BRANCH_NAME')
    }

    steps {
        shell('wget https://raw.githubusercontent.com/MNT-Lab/mntlab-dsl/ikhamiakou/work.sh')
        shell('chmod +x work.sh')
        shell('./work.sh')
                
            
        publishers {
        archiveArtifacts('*')
        }
    }
    
    
}

job('MNTLAB-ikhamiakou-child4-build-job') {
    
    parameters{
        activeChoiceReactiveParam('jobs') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["ikhamiakou", "master"]')
            }
        }
    }
    
    scm {
        github('MNT-Lab/mntlab-dsl', '$BRANCH_NAME')
    }

    steps {
        shell('wget https://raw.githubusercontent.com/MNT-Lab/mntlab-dsl/ikhamiakou/work.sh')
        shell('chmod +x work.sh')
        shell('./work.sh')
         
 
        publishers {
        archiveArtifacts('*')
        }
    }
    
}    
}