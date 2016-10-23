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
package org.ol3cesium.olx.control;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ControlOptions extends JavaScriptObject {
    protected ControlOptions() {
        //
    }
    
    public static native ControlOptions create() /*-{
        return {};
    }-*/;
    
    public final native void setElement(Element element) /*-{
        this.element = element;
    }-*/;
    
    public final native void setTraget(Element target) /*-{
        this.target = target;
    }-*/;
}