package com.leonardo.ecommerce.enums;


import lombok.Getter;



@Getter
public enum CategoryEnums {
        VESTIDOS("Vestidos"),
        BLUSAS("Blusas"),
        CALCAS("Calças"),
        SAIAS("Saias"),
        CASACOS("Casacos"),
        SAPATOS("Sapatos"),
        BOLSAS("Bolsas"),
        ACESSORIOS("Acessórios"),
        LINGERIE("Lingerie"),
        FITNESS("Fitness"),
        MODA_PRAIA("Moda Praia"),
        MEIAS_E_COLLANTS("Meias e Collants"),
        JOIAS("Joias"),
        PERFUMES("Perfumes"),
        MAQUIAGEM("Maquiagem"),
        CABELO("Cabelo");

    CategoryEnums(String categoryEnums) {
    }
}
