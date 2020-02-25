package de.gematik.ti.epa.fdv.authentication.integration;

import de.gematik.ti.cardreader.provider.api.card.ICard;
import de.gematik.ti.healthcardaccess.HealthCard;
import de.gematik.ti.healthcardaccess.IHealthCardStatus;

public class TestHealthCard extends HealthCard {

    public TestHealthCard(final ICard card, final IHealthCardStatus status) {
        super(card, status);
    }

}
