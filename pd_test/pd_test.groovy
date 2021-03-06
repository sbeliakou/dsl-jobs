def jobName="PD-shop-commerce-test-build"

job(jobName) {
    multiscm {
        git {
            remote {
                github('DigitalInnovation/shop-UX', 'ssh')
                branch('*/${BRANCH_NAME}')
                credentials('215ce03e-3655-430f-8b86-4753fdb5161f')
            }
            extensions {
                relativeTargetDirectory('ux')
            }
        }
        git {
            remote {
                github('DigitalInnovation/shop-common-assets', 'ssh')
                branch('*/${BRANCH_NAME}')
                credentials('215ce03e-3655-430f-8b86-4753fdb5161f')
            }
            extensions {
                relativeTargetDirectory('common-assets')
            }
        }
        git {
            remote {
                github('DigitalInnovation/shop-bnr', 'ssh')
                credentials('215ce03e-3655-430f-8b86-4753fdb5161f')
                branch('*/master')
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
