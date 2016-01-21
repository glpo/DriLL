package com.angl.drill.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = ModalRoutingCard.MODAL_ROUTING_CARD_NAME)
public class ModalRoutingCard {
    public static final String MODAL_ROUTING_CARD_NAME = "routing_cards";

    public ModalRoutingCard() {
    }

    @JsonIgnore
    @Id
    private ObjectId id;

    private String name;

    private List<Integer> depth;

    private List<String> litology;

    private List<String> constans;

    private List<String> construction;

    private List<String> complications;

    private List<String> bitSize;

    private List<String> crossSection;

    private List<Integer> Nd;

    private List<Double> T;

    private List<String> V;

    private List<String> KNBK;

    private List<String> drillingMethod;

    private List<String> Gd;

    private List<String> Np;

    private List<String> Q;

    private List<Integer> P;

    private List<String> ro;

    private List<String> F3;

    private List<String> Tfluid;

    private List<String> CH3;

    private List<Integer> TT;

    private List<String> fluidType;

    public List<Integer> getDepth() {
        return depth;
    }

    public List<String> getLitology() {
        return litology;
    }

    public List<String> getConstans() {
        return constans;
    }

    public List<String> getConstruction() {
        return construction;
    }

    public List<String> getComplications() {
        return complications;
    }

    public List<String> getBitSize() {
        return bitSize;
    }

    public List<String> getCrossSection() {
        return crossSection;
    }

    public List<Integer> getNd() {
        return Nd;
    }

    public List<Double> getT() {
        return T;
    }

    public List<String> getV() {
        return V;
    }

    public List<String> getKNBK() {
        return KNBK;
    }

    public List<String> getDrillingMethod() {
        return drillingMethod;
    }

    public List<String> getGd() {
        return Gd;
    }

    public List<String> getNp() {
        return Np;
    }

    public List<String> getQ() {
        return Q;
    }

    public List<Integer> getP() {
        return P;
    }

    public List<String> getRo() {
        return ro;
    }

    public List<String> getF3() {
        return F3;
    }

    public List<String> getTfluid() {
        return Tfluid;
    }

    public List<String> getCH3() {
        return CH3;
    }

    public List<Integer> getTT() {
        return TT;
    }

    public List<String> getFluidType() {
        return fluidType;
    }

    public void setDepth(List<Integer> depth) {
        this.depth = depth;
    }

    public void setLitology(List<String> litology) {
        this.litology = litology;
    }

    public void setConstans(List<String> constans) {
        this.constans = constans;
    }

    public void setConstruction(List<String> construction) {
        this.construction = construction;
    }

    public void setComplications(List<String> complications) {
        this.complications = complications;
    }

    public void setBitSize(List<String> bitSize) {
        this.bitSize = bitSize;
    }

    public void setCrossSection(List<String> crossSection) {
        this.crossSection = crossSection;
    }

    public void setNd(List<Integer> nd) {
        Nd = nd;
    }

    public void setT(List<Double> t) {
        T = t;
    }

    public void setV(List<String> v) {
        V = v;
    }

    public void setKNBK(List<String> KNBK) {
        this.KNBK = KNBK;
    }

    public void setDrillingMethod(List<String> drillingMethod) {
        this.drillingMethod = drillingMethod;
    }

    public void setGd(List<String> gd) {
        Gd = gd;
    }

    public void setNp(List<String> np) {
        Np = np;
    }

    public void setQ(List<String> q) {
        Q = q;
    }

    public void setP(List<Integer> p) {
        P = p;
    }

    public void setRo(List<String> ro) {
        this.ro = ro;
    }

    public void setF3(List<String> f3) {
        F3 = f3;
    }

    public void setTfluid(List<String> tfluid) {
        Tfluid = tfluid;
    }

    public void setCH3(List<String> CH3) {
        this.CH3 = CH3;
    }

    public void setTT(List<Integer> TT) {
        this.TT = TT;
    }

    public void setFluidType(List<String> fluidType) {
        this.fluidType = fluidType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
