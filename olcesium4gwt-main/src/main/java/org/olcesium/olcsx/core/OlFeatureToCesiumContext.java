package org.olcesium.olcsx.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Feature;
import ol.proj.Projection;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.collections.PrimitiveCollection;

import java.util.Map;

/**
 * Created by mribeiro on 21/08/19.
 */
@JsType(isNative = true, namespace = "olcsx.core", name = "OlFeatureToCesiumContext")
public class OlFeatureToCesiumContext {

    @JsProperty
    public Projection layerProjection;

    @JsProperty
    public BillboardCollection billboards;

    @JsProperty
    Map<String, Feature> featureToCesiumMap;

    @JsProperty
    public PrimitiveCollection primitives;
}
