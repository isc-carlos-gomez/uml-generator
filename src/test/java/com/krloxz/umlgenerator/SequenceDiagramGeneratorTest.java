package com.krloxz.umlgenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.OutputStream;

import org.junit.jupiter.api.Test;

public class SequenceDiagramGeneratorTest {

    @Test
    public void generateGeneratesInteractionWithGeneratorMatchingOperation() {
        final OutputStream output = mock(OutputStream.class);
        final OutputFormat format = OutputFormat.PLANT_UML;
        final Operation operation = mock(Operation.class);
        final InteractionGenerator generator = mock(InteractionGenerator.class);
        final InteractionGeneratorFactory generatorFactory = mock(InteractionGeneratorFactory.class);
        when(generatorFactory.getGenerator(operation)).thenReturn(generator);

        final SequenceDiagramGenerator diagramGenerator = new SequenceDiagramGenerator(generatorFactory);
        diagramGenerator.generate(output, format);

        // verify(renderer).render(output);
    }

    @Test
    public void generateRendersInteractionWithRendererMatchingRequestedFormat() {
        final OutputStream output = mock(OutputStream.class);
        final OutputFormat format = OutputFormat.PLANT_UML;
        final InteractionRenderer renderer = mock(InteractionRenderer.class);
        final InteractionRendererFactory rendererFactory = mock(InteractionRendererFactory.class);
        when(rendererFactory.getRenderer(format)).thenReturn(renderer);

        final SequenceDiagramGenerator generator = new SequenceDiagramGenerator(rendererFactory);
        generator.generate(output, format);

        verify(renderer).render(output);
    }

    @Test
    public void shouldGenerateDiagramAsPngImage() {
    }

    @Test
    public void shouldGenerateDiagramAsSvgImage() {

    }

    @Test
    public void shouldGenerateDiagramAsEpsImage() {

    }

    @Test
    public void shouldGenerateDiagramAsPlantUMLString() {
        final OutputStream output = mock(OutputStream.class);
        final PlantUmlInteractionRenderer renderer = mock(PlantUmlInteractionRenderer.class);
        final InteractionRendererFactory rendererFactory = mock(InteractionRendererFactory.class);
        when(rendererFactory.getRenderer(OutputFormat.PLANT_UML)).thenReturn(renderer);

        final SequenceDiagramGenerator generator = new SequenceDiagramGenerator(rendererFactory);
        generator.generate(output, OutputFormat.PLANT_UML);

        verify(renderer).render(output);
    }

}
