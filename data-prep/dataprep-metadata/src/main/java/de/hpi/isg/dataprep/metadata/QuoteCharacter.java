package de.hpi.isg.dataprep.metadata;

import de.hpi.isg.dataprep.exceptions.RuntimeMetadataException;
import de.hpi.isg.dataprep.model.repository.MetadataRepository;
import de.hpi.isg.dataprep.model.target.objects.Metadata;
import de.hpi.isg.dataprep.model.target.objects.MetadataScope;

import java.util.Objects;

/**
 * A pairwise string identifier wraps the position of real data content in a data file.
 *
 * @author Lan Jiang
 * @since 2018/8/28
 */
public class QuoteCharacter extends Metadata {

    private String QuoteCharacter;

    private QuoteCharacter() {
        super("quote");
    }

    public QuoteCharacter(MetadataScope scope, String quoteCharacter) {
        this();
        this.scope = scope;
        QuoteCharacter = quoteCharacter;
    }

    @Override
    public void checkMetadata(MetadataRepository metadataRepository) throws RuntimeMetadataException {

    }

    @Override
    public boolean equalsByValue(Metadata metadata) {
        return this.equals(metadata);
    }

    public String getQuoteCharacter() {
        return QuoteCharacter;
    }
}
