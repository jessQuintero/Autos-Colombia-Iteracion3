package datos;


import javax.swing.JOptionPane;

public interface Mensajes {
    
    public static void mostrarMensaje(String titulo, String msg, int tipo){
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }
    
    public static void mensajeError(String titulo,String msg){
        mostrarMensaje(titulo,msg, JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean mensajeConfirm(String titulo,String msg){
        JOptionPane jP=new JOptionPane();
        return jP.showConfirmDialog(null,msg,titulo, jP.YES_NO_OPTION)== jP.YES_OPTION;
    }
}
