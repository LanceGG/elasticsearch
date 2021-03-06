/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
import org.elasticsearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
import org.elasticsearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
import org.elasticsearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;

import java.io.IOException;

import static java.util.Collections.emptySet;

/**
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Snapshot API.
 * <p>
 * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html">Snapshot API on elastic.co</a>
 */
public final class SnapshotClient {
    private final RestHighLevelClient restHighLevelClient;

    SnapshotClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * Gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all
     * registered repositories are returned.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param getRepositoriesRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public GetRepositoriesResponse getRepository(GetRepositoriesRequest getRepositoriesRequest, RequestOptions options)
        throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(getRepositoriesRequest, RequestConverters::getRepositories, options,
            GetRepositoriesResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously gets a list of snapshot repositories. If the list of repositories is empty or it contains a single element "_all", all
     * registered repositories are returned.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param getRepositoriesRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void getRepositoryAsync(GetRepositoriesRequest getRepositoriesRequest, RequestOptions options,
                                   ActionListener<GetRepositoriesResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(getRepositoriesRequest, RequestConverters::getRepositories, options,
            GetRepositoriesResponse::fromXContent, listener, emptySet());
    }

    /**
     * Creates a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param putRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public AcknowledgedResponse createRepository(PutRepositoryRequest putRepositoryRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(putRepositoryRequest, RequestConverters::createRepository, options,
            AcknowledgedResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously creates a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param putRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void createRepositoryAsync(PutRepositoryRequest putRepositoryRequest, RequestOptions options,
                                      ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(putRepositoryRequest, RequestConverters::createRepository, options,
            AcknowledgedResponse::fromXContent, listener, emptySet());
    }

    /**
     * Deletes a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param deleteRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public AcknowledgedResponse deleteRepository(DeleteRepositoryRequest deleteRepositoryRequest, RequestOptions options)
        throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(deleteRepositoryRequest, RequestConverters::deleteRepository, options,
            AcknowledgedResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously deletes a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param deleteRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void deleteRepositoryAsync(DeleteRepositoryRequest deleteRepositoryRequest, RequestOptions options,
                                      ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(deleteRepositoryRequest, RequestConverters::deleteRepository, options,
            AcknowledgedResponse::fromXContent, listener, emptySet());
    }

    /**
     * Verifies a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param verifyRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public VerifyRepositoryResponse verifyRepository(VerifyRepositoryRequest verifyRepositoryRequest, RequestOptions options)
        throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(verifyRepositoryRequest, RequestConverters::verifyRepository, options,
            VerifyRepositoryResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously verifies a snapshot repository.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param verifyRepositoryRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void verifyRepositoryAsync(VerifyRepositoryRequest verifyRepositoryRequest, RequestOptions options,
                                      ActionListener<VerifyRepositoryResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(verifyRepositoryRequest, RequestConverters::verifyRepository, options,
            VerifyRepositoryResponse::fromXContent, listener, emptySet());
    }

    /**
     * Creates a snapshot.
     * <p>
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     */
    public CreateSnapshotResponse create(CreateSnapshotRequest createSnapshotRequest, RequestOptions options)
        throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(createSnapshotRequest, RequestConverters::createSnapshot, options,
            CreateSnapshotResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously creates a snapshot.
     * <p>
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     */
    public void createAsync(CreateSnapshotRequest createSnapshotRequest, RequestOptions options,
                                    ActionListener<CreateSnapshotResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(createSnapshotRequest, RequestConverters::createSnapshot, options,
            CreateSnapshotResponse::fromXContent, listener, emptySet());
    }

    /**
     * Get snapshots.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param getSnapshotsRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public GetSnapshotsResponse get(GetSnapshotsRequest getSnapshotsRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(getSnapshotsRequest, RequestConverters::getSnapshots, options,
            GetSnapshotsResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously get snapshots.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param getSnapshotsRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void getAsync(GetSnapshotsRequest getSnapshotsRequest, RequestOptions options, ActionListener<GetSnapshotsResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(getSnapshotsRequest, RequestConverters::getSnapshots, options,
            GetSnapshotsResponse::fromXContent, listener, emptySet());
    }

    /**
     * Gets the status of requested snapshots.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param snapshotsStatusRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public SnapshotsStatusResponse status(SnapshotsStatusRequest snapshotsStatusRequest, RequestOptions options)
        throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(snapshotsStatusRequest, RequestConverters::snapshotsStatus, options,
            SnapshotsStatusResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously gets the status of requested snapshots.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     * @param snapshotsStatusRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void statusAsync(SnapshotsStatusRequest snapshotsStatusRequest, RequestOptions options,
                            ActionListener<SnapshotsStatusResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(snapshotsStatusRequest, RequestConverters::snapshotsStatus, options,
            SnapshotsStatusResponse::fromXContent, listener, emptySet());
    }

    /**
     * Restores a snapshot.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param restoreSnapshotRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public RestoreSnapshotResponse restore(RestoreSnapshotRequest restoreSnapshotRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(restoreSnapshotRequest, RequestConverters::restoreSnapshot, options,
            RestoreSnapshotResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously restores a snapshot.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param restoreSnapshotRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void restoreAsync(RestoreSnapshotRequest restoreSnapshotRequest, RequestOptions options,
                            ActionListener<RestoreSnapshotResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(restoreSnapshotRequest, RequestConverters::restoreSnapshot, options,
            RestoreSnapshotResponse::fromXContent, listener, emptySet());
    }

    /**
     * Deletes a snapshot.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param deleteSnapshotRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public AcknowledgedResponse delete(DeleteSnapshotRequest deleteSnapshotRequest, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(deleteSnapshotRequest, RequestConverters::deleteSnapshot, options,
            AcknowledgedResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously deletes a snapshot.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-snapshots.html"> Snapshot and Restore
     * API on elastic.co</a>
     *
     * @param deleteSnapshotRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void deleteAsync(DeleteSnapshotRequest deleteSnapshotRequest, RequestOptions options,
                            ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(deleteSnapshotRequest, RequestConverters::deleteSnapshot, options,
            AcknowledgedResponse::fromXContent, listener, emptySet());
    }
}
