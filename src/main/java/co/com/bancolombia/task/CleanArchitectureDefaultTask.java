package co.com.bancolombia.task;

import co.com.bancolombia.factory.ModuleBuilder;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.internal.tasks.options.OptionReader;
import org.gradle.api.logging.Logger;
import org.gradle.configuration.TaskDetailPrinter;
import org.gradle.execution.TaskSelector;
import org.gradle.internal.logging.text.StyledTextOutput;
import org.gradle.internal.logging.text.StyledTextOutputFactory;

import javax.inject.Inject;

public class CleanArchitectureDefaultTask extends DefaultTask {
    protected final ModuleBuilder builder = new ModuleBuilder(getProject());
    protected final Logger logger = getProject().getLogger();

    protected void printHelp() {
        StyledTextOutput output = this.getTextOutputFactory().create(CleanArchitectureDefaultTask.class);
        final Task task = this;
        TaskSelector.TaskSelection selection = new TaskSelector.TaskSelection(getPath(), getName(),
                collection -> collection.add(task));
        OptionReader optionReader = this.getOptionReader();
        TaskDetailPrinter taskDetailPrinter = new TaskDetailPrinter(getName(), selection, optionReader);
        taskDetailPrinter.print(output);
    }

    @Inject
    protected StyledTextOutputFactory getTextOutputFactory() {
        throw new UnsupportedOperationException();
    }

    @Inject
    protected OptionReader getOptionReader() {
        throw new UnsupportedOperationException();
    }
}
