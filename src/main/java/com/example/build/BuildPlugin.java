package com.example.build;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class BuildPlugin implements Plugin<Project> {
    private static String VERSION = "1.0.0";
    @Override
    public void apply(Project project) {
        // Plugin logic goes here
        project.getLogger().quiet("Custom Gradle Plugin Applied " + VERSION + "!");
//        // Applying AnotherPlugin with a specific version

        project.getTasks().register("hello", task -> {
            task.doLast(new Action<Task>() {
                @Override
                public void execute(Task t) {
                    System.out.println("Hello! from the BuildPlugin " + VERSION);
                }
            });
        });
    }
}
