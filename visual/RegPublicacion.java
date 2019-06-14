package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerDateModel;

import java.text.SimpleDateFormat;

import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class RegPublicacion extends JDialog {

	@SuppressWarnings("unused")
	private JPanel contentPanel;
	private JPanel pnPrincipal;
	private JTextField tfAutor;
	private JTextField tfTitulo;
	private JTextField tfID;
	private JLabel lblCantEjemplares;
	private JLabel lblAutor;
	private JLabel lblMateria;
	@SuppressWarnings("rawtypes")
	private JComboBox cbMateria;
	private JSpinner spnCant;
	private JLabel lblTitulo;
	private JPanel pnTipoPublicacion;
	private JPanel pnInformacion;
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnLibro;
	private JRadioButton rdbtnRevista;
	private JRadioButton rdbtnArticulo;
	private JPanel pnPublicacion;
	private JLabel lblFechaPublicacion;
	private JSpinner spnFechaPublicacion;
	private JLabel lblNumero;
	private JSpinner spnNumRevista;

	public RegPublicacion() {
		setTitle("Nueva Publicacion");
		iniciarComponentes();
		crearEventos();
	}
	
	@SuppressWarnings("rawtypes")
	private void iniciarComponentes() {
		contentPanel = new JPanel();
		buttonGroup = new ButtonGroup();
		pnPrincipal = new JPanel();
		setBounds(100, 100, 434, 463);
		getContentPane().setLayout(new BorderLayout());
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnPrincipal, BorderLayout.CENTER);
		
		pnInformacion = new JPanel();
		pnInformacion.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnTipoPublicacion = new JPanel();
		pnTipoPublicacion.setBorder(new TitledBorder(null, "Tipo de Publicacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnPublicacion = new JPanel();
		GroupLayout gl_pnPrincipal = new GroupLayout(pnPrincipal);
		gl_pnPrincipal.setHorizontalGroup(
			gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(pnPublicacion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(pnTipoPublicacion, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(pnInformacion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnPrincipal.setVerticalGroup(
			gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPrincipal.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnInformacion, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnTipoPublicacion, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnPublicacion, GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblFechaPublicacion = new JLabel("Fecha Publicacion:");
		
		SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
		spnFechaPublicacion = new JSpinner(new SpinnerDateModel());
		spnFechaPublicacion.setEditor(new JSpinner.DateEditor(spnFechaPublicacion, model.toPattern()));
		
		lblNumero = new JLabel("Numero:");
		
		spnNumRevista = new JSpinner();
		spnNumRevista.setModel(new SpinnerNumberModel(1, 1, 99999, 1));
		
		GroupLayout gl_pnPublicacion = new GroupLayout(pnPublicacion);
		gl_pnPublicacion.setHorizontalGroup(
			gl_pnPublicacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPublicacion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnPublicacion.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaPublicacion)
						.addComponent(lblNumero))
					.addGap(18)
					.addGroup(gl_pnPublicacion.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spnNumRevista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spnFechaPublicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_pnPublicacion.setVerticalGroup(
			gl_pnPublicacion.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnPublicacion.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addGroup(gl_pnPublicacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaPublicacion)
						.addComponent(spnFechaPublicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnPublicacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(spnNumRevista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		pnPublicacion.setLayout(gl_pnPublicacion);
		
		rdbtnLibro = new JRadioButton("Libro");
		rdbtnLibro.setSelected(true);
		buttonGroup.add(rdbtnLibro);
		
		rdbtnRevista = new JRadioButton("Revista");
		buttonGroup.add(rdbtnRevista);
		
		rdbtnArticulo = new JRadioButton("Articulo");
		buttonGroup.add(rdbtnArticulo);
		GroupLayout gl_pnTipoPublicacion = new GroupLayout(pnTipoPublicacion);
		gl_pnTipoPublicacion.setHorizontalGroup(
			gl_pnTipoPublicacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTipoPublicacion.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnLibro)
					.addGap(101)
					.addComponent(rdbtnRevista)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(rdbtnArticulo)
					.addContainerGap())
		);
		gl_pnTipoPublicacion.setVerticalGroup(
			gl_pnTipoPublicacion.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnTipoPublicacion.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addGroup(gl_pnTipoPublicacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnLibro)
						.addComponent(rdbtnArticulo)
						.addComponent(rdbtnRevista))
					.addContainerGap())
		);
		pnTipoPublicacion.setLayout(gl_pnTipoPublicacion);
		
		JLabel lblId = new JLabel("ID:");
		
		lblTitulo = new JLabel("Titulo:");
		
		lblMateria = new JLabel("Materia:");
		
		lblAutor = new JLabel("Autor:");
		
		cbMateria = new JComboBox();
		
		lblCantEjemplares = new JLabel("Cant. Ejemplares:");
		
		spnCant = new JSpinner();
		spnCant.setModel(new SpinnerNumberModel(1, 1, 99999, 1));
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		
		tfTitulo = new JTextField();
		tfTitulo.setColumns(10);
		
		tfID = new JTextField();
		tfID.setColumns(10);
		GroupLayout gl_pnInformacion = new GroupLayout(pnInformacion);
		gl_pnInformacion.setHorizontalGroup(
			gl_pnInformacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnInformacion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMateria)
						.addComponent(lblAutor)
						.addComponent(lblTitulo)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.LEADING)
						.addComponent(tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnInformacion.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tfTitulo)
							.addGroup(gl_pnInformacion.createSequentialGroup()
								.addComponent(cbMateria, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblCantEjemplares)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(spnCant, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addComponent(tfAutor)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnInformacion.setVerticalGroup(
			gl_pnInformacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnInformacion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(tfTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMateria)
						.addComponent(cbMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantEjemplares)
						.addComponent(spnCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnInformacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(tfAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		pnInformacion.setLayout(gl_pnInformacion);
		pnPrincipal.setLayout(gl_pnPrincipal);
		{
			JPanel btnPrincipal = new JPanel();
			btnPrincipal.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPrincipal, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				btnPrincipal.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				btnPrincipal.add(cancelButton);
			}
		}
	}
	
	private void crearEventos() {
		
	}
}
