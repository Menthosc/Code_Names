var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Angular: {
    var Personne = /** @class */ (function () {
        function Personne(nom, prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }
        return Personne;
    }());
}
var Client = /** @class */ (function (_super) {
    __extends(Client, _super);
    function Client(nom, prenom, ca) {
        var _this = _super.call(this, nom, prenom) || this;
        _this.nom = nom;
        _this.prenom = prenom;
        _this.ca = ca;
        _this.produits = new Array();
        return _this;
    }
    return Client;
}(Personne));
var Fournisseur = /** @class */ (function (_super) {
    __extends(Fournisseur, _super);
    function Fournisseur(nom, prenom, nomSociete) {
        var _this = _super.call(this, nom, prenom) || this;
        _this.nom = nom;
        _this.prenom = prenom;
        _this.nomSociete = nomSociete;
        return _this;
    }
    return Fournisseur;
}(Personne));
var Produit = /** @class */ (function () {
    function Produit(nom, prix, fournisseur) {
        this.nom = nom;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.clients = new Array();
    }
    return Produit;
}());
