def jobName="PD-shop-commerce-test-build"

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
        shell(readFileFromWorkspace('pd_test/build.sh'))
    }
}
