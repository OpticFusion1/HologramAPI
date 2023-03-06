package optic_fusion1.hologram.animation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The AnimationHandler class is responsible for managing a collection of {@link AnimationTask} objects.
 */
public class AnimationHandler {

    /**
     * A list of {@link AnimationTask} objects.
     */
    private List<AnimationTask> TASKS = new ArrayList<>();

    /**
     * Returns an unmodifiable view of the task collection.
     *
     * @return an unmodifiable collection of {@link AnimationTask} objects.
     */
    public Collection<AnimationTask> getTasks() {
        return Collections.unmodifiableCollection(TASKS);
    }

    /**
     * Clears the task collection.
     */
    public void clearTasks() {
        TASKS.clear();
    }

    /**
     * Activates all tasks in the task collection.
     */
    public void activateAll() {
        for (AnimationTask task : TASKS) {
            task.activate();
        }
    }

    /**
     * Deactivates all tasks in the task collection.
     */
    public void deactivateAll() {
        for (AnimationTask task : TASKS) {
            if (task != null) {
                task.deactivate();
            }
        }
    }

    /**
     * Adds a new {@link AnimationTask} to the task collection.
     *
     * @param task The {@link AnimationTask} to be added.
     */
    public void addAnimationTask(AnimationTask task) {
        TASKS.add(task);
    }
}
