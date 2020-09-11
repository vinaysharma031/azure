#!/usr/bin/env groovy
def tgt() {

archiveArtifacts '$target'

}
return [
    tgt: this.&tgt
]

