/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2021 Andres Almiray.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.model;

import static org.jreleaser.util.StringUtils.isBlank;

/**
 * @author Andres Almiray
 * @since 0.3.0
 */
public interface Uploader extends Domain, Activatable, TimeoutAware, ExtraProperties {
    String getType();

    String getName();

    void setName(String name);

    boolean isSnapshotSupported();

    Boolean isArtifacts();

    void setArtifacts(Boolean artifacts);

    boolean isArtifactsSet();

    Boolean isFiles();

    void setFiles(Boolean files);

    boolean isFilesSet();

    Boolean isSignatures();

    void setSignatures(Boolean signatures);

    boolean isSignaturesSet();

    enum Method {
        PUT,
        POST;

        @Override
        public String toString() {
            return name().toLowerCase();
        }

        public static HttpUploader.Method of(String str) {
            if (isBlank(str)) return null;
            return HttpUploader.Method.valueOf(str.toUpperCase().trim());
        }
    }

    public enum Authorization {
        NONE,
        BASIC,
        BEARER;

        @Override
        public String toString() {
            return name().toLowerCase();
        }

        public static HttpUploader.Authorization of(String str) {
            if (isBlank(str)) return null;
            return HttpUploader.Authorization.valueOf(str.toUpperCase().trim());
        }
    }
}