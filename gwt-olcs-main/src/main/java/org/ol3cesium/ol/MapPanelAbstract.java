/*
 * Copyright 2016 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ol3cesium.ol;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import org.ol3cesium.Configuration;
import org.ol3cesium.OpenLayers3;

/**
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public abstract class MapPanelAbstract extends SimplePanel {
    private final Configuration _configuration;
    private Map _map;

    public MapPanelAbstract(Configuration configuration) {
        _configuration = configuration;
        super.addAttachHandler(new Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                if (event.isAttached()) {
                    inject(getElement());
                }
            }
        });
    }
    
    protected void inject(final Element element) {
        Document document = element.getOwnerDocument();
        OpenLayers3.initialize(_configuration.getPath(), _configuration.getName(), _configuration.getStyles(), document, new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                Window.alert("Error: Failed to inject scripts from "+ _configuration.getPath() + _configuration.getName());
            }

            @Override
            public void onSuccess(Void result) {
                _map = create(element);
            }
        });
    }
    
    public abstract Map create(Element element);
    
    public Map get(){
        return _map;
    }
}