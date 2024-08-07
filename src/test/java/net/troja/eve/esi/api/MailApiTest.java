/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.troja.eve.esi.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import net.troja.eve.esi.ApiException;
import net.troja.eve.esi.model.MailHeadersResponse;

/**
 * API tests for MailApi
 */
public class MailApiTest extends GeneralApiTest {

    private final MailApi api = new MailApi();

    @Before
    public void setUp() {
        api.setApiClient(apiClient);
    }

    /**
     * Delete a mail label
     *
     * Delete a mail label  ---   SSO Scope: esi-mail.organize_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Delete operations can't be tested")
    public void deleteCharactersCharacterIdMailLabelsLabelIdTest() throws ApiException {
    }

    /**
     * Delete a mail
     *
     * Delete a mail  ---   SSO Scope: esi-mail.organize_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Delete operations can't be tested")
    public void deleteCharactersCharacterIdMailMailIdTest() throws ApiException {
    }

    /**
     * Return mail headers
     *
     * Return the 50 most recent mail headers belonging to the character that match the query criteria. Queries can be filtered by label, and last_mail_id can be used to paginate backwards  ---  This route is cached for up to 30 seconds  SSO Scope: esi-mail.read_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailTest() throws ApiException {
        final Set<Integer> labels = null;
        final Integer lastMailId = null;
        final List<MailHeadersResponse> response = api.getCharactersCharacterIdMail(characterId, DATASOURCE, null, labels, lastMailId, null);

        assertThat(response.size(), equalTo(50));
        final MailHeadersResponse headers = response.get(0);
        assertThat(headers.getFrom(), greaterThan(0));
        assertThat(!headers.getSubject().isEmpty(), equalTo(true));
    }

    /**
     * Get mail labels and unread counts
     *
     * Return a list of the users mail labels, unread counts for each label and a total unread count.  ---  This route is cached for up to 30 seconds  SSO Scope: esi-mail.read_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailLabelsTest() throws ApiException {
        // final Integer characterId = null;
        // MailLabelsResponse response =
        // api.getCharactersCharacterIdMailLabels(characterId, DATASOURCE);

        // TODO: test validations
    }

    /**
     * Return mailing list subscriptions
     *
     * Return all mailing lists that the character is subscribed to  ---  This route is cached for up to 120 seconds  SSO Scope: esi-mail.read_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailListsTest() throws ApiException {
        // final Integer characterId = null;
        // List<CharacterMailinglistsResponse> response =
        // api.getCharactersCharacterIdMailLists(characterId, DATASOURCE);

        // TODO: test validations
    }

    /**
     * Return a mail
     *
     * Return the contents of an EVE mail  ---  This route is cached for up to 30 seconds  SSO Scope: esi-mail.read_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    public void getCharactersCharacterIdMailMailIdTest() throws ApiException {
        // final Integer characterId = null;
        final Integer mailId = null;
        // MailResponse response =
        // api.getCharactersCharacterIdMailMailId(characterId, mailId,
        // DATASOURCE);

        // TODO: test validations
    }

    /**
     * Send a new mail
     *
     * Create and send a new mail  ---   SSO Scope: esi-mail.send_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Send operations can't be tested")
    public void postCharactersCharacterIdMailTest() throws ApiException {
    }

    /**
     * Create a mail label
     *
     * Create a mail label  ---   SSO Scope: esi-mail.organize_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Create operations can't be tested")
    public void postCharactersCharacterIdMailLabelsTest() throws ApiException {
    }

    /**
     * Update metadata about a mail
     *
     * Update metadata about a mail  ---   SSO Scope: esi-mail.organize_mail.v1
     *
     * @throws ApiException
     *             if the Api call fails
     */
    @Test
    @Ignore("Update operations can't be tested")
    public void putCharactersCharacterIdMailMailIdTest() throws ApiException {
    }
}
