Angular :


class Personne {
    constructor(public nom: string, public prenom?: string) { }
}

class Client extends Personne {
    private produits: Array<Produit> = new Array<Produit>();
    constructor(public nom: string, public prenom?: string, public ca?: number) {
        super(nom, prenom);
    }
}

class Fournisseur extends Personne {
    constructor(public nom: string, public prenom?: string, public nomSociete?: string) {
        super(nom, prenom);
    }
}

class Produit {
    private clients: Array<Client> = new Array<Client>();
    constructor(public nom: string, public prix: number, public fournisseur?: Fournisseur) { }
}
