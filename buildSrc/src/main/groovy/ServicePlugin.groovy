import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.artifacts.publish.ArchivePublishArtifact;
import org.gradle.api.tasks.Delete;
import org.gradle.api.tasks.bundling.Tar;
import org.gradle.api.tasks.bundling.Compression;

class ServicePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.configurations.create("archives")

        project.task('package', type: Tar) { task ->
            project.gradle.projectsEvaluated {
                baseName "${project.name}Service"
                version project.version.toString()
                destinationDir project.buildDir
                compression Compression.GZIP
                extension "tar.gz"

                from ('.')
                into baseName

                include 'conf/**/*'
                include 'lib/**/*'
                include 'bin/**/*'

                ArchivePublishArtifact tarArtifact = new ArchivePublishArtifact(task)
                project.configurations.getByName("archives").getArtifacts().add(tarArtifact)
            }
        }

        project.task('clean', type: Delete) {
            delete project.buildDir
        }
    }
}