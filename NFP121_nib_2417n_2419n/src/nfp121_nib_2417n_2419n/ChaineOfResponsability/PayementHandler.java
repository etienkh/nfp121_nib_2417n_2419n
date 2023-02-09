/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.ChaineOfResponsability;

/**
 *
 * @author Georges
 */
abstract class PayementHandler {

  protected PayementHandler successor;

    abstract public void processRequest();

    public void setSuccessor(PayementHandler successor) {
        this.successor = successor;
    }
}
