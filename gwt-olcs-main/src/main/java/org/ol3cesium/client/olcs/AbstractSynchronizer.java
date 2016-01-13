/* 
 * Copyright 2016 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ol3cesium.client.olcs;

import com.google.gwt.core.client.JavaScriptObject;
import org.cesiumjs.cesium.Scene;
import org.ol3cesium.client.ol.Map;

/**
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class AbstractSynchronizer extends JavaScriptObject {
    protected AbstractSynchronizer() {
        //
    }
    
    public static final native AbstractSynchronizer create(Map map, Scene scene) /*-{
        return new olcs.AbstractSynchronizer(map, scene);
    }-*/;
    
    public final native void synchronize() /*-{
        this.synchronize();
    }-*/;
}
