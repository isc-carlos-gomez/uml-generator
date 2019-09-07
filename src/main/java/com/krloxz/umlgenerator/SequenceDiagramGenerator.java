package com.krloxz.umlgenerator;

import java.io.OutputStream;

public class SequenceDiagramGenerator {

    private InteractionRendererFactory redererFactory;

    public SequenceDiagramGenerator(final InteractionRendererFactory rendererFactory) {
        this.redererFactory = rendererFactory;
    }

    public SequenceDiagramGenerator(final InteractionGeneratorFactory generatorFactory) {
        // TODO Auto-generated constructor stub
    }

    public void generate(final OutputStream output, final OutputFormat outputFormat) {
        final InteractionRenderer renderer = this.redererFactory.getRenderer(outputFormat);
        renderer.render(output);
    }

}
