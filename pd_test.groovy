def jobName="PD-shop-commerce-test-build"
def shell_script='''#!/bin/bash
echo step 1
echo step 2
'''

job(jobName) {
     multiscm {
        git {
            remote {
                github('DigitalInnovation/shop-UX', 'ssh')
                branch('*/${BRANCH_NAME}')
            }
            extensions {
                relativeTargetDirectory('ux')
            }
        }
        git {
            remote {
                github('DigitalInnovation/shop-common-assets', 'ssh')
                branch('*/${BRANCH_NAME}')
            }
            extensions {
                relativeTargetDirectory('common-assets')
            }
        }
        git {
            remote {
                github('DigitalInnovation/shop-bnr', 'ssh')
            }
            extensions {
                relativeTargetDirectory('utils')
            }
        }
    }
    steps {
        shell(shell_script)
    }
}
