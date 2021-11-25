package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import br.senai.sp.jandira.model.Console;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class FrameJogos extends JFrame {

	private JPanel contentPane;
	private JTextField txtTituloJogo;
	private JTextField txtValorEstimado;
	private JTextField txtObservações;

	private int posicao = 0;

	public FrameJogos() {
		setTitle("Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloJogo = new JLabel("T\u00EDtulo do jogo:");
		lblTituloJogo.setBounds(21, 65, 102, 14);
		contentPane.add(lblTituloJogo);

		txtTituloJogo = new JTextField();
		txtTituloJogo.setBounds(132, 65, 152, 20);
		contentPane.add(txtTituloJogo);
		txtTituloJogo.setColumns(10);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(21, 96, 102, 14);
		contentPane.add(lblFabricante);

		JComboBox<String> comboBoxFabricante = new JComboBox<String>();
		comboBoxFabricante.setBounds(132, 96, 152, 22);
		
		DefaultComboBoxModel<String> modelFabricante = new DefaultComboBoxModel<String>();
		
		FabricanteRepository fabricantes = new FabricanteRepository();
		
		for (Fabricante fabricante : fabricantes.getFabricantes()) {
			modelFabricante.addElement(fabricante.getNome());
		}
		
		comboBoxFabricante.setModel(modelFabricante);
		contentPane.add(comboBoxFabricante);

		JCheckBox chckbxZerado = new JCheckBox("Zerado");
		chckbxZerado.setBounds(132, 129, 97, 23);
		contentPane.add(chckbxZerado);

		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(21, 166, 102, 14);
		contentPane.add(lblConsole);

		JComboBox comboBoxConsole = new JComboBox();
		DefaultComboBoxModel<String> modelConsole = new DefaultComboBoxModel<String>();
		for (Console c : Console.values()) {
			modelConsole.addElement(c.getDescricao());
		}
		comboBoxConsole.setModel(modelConsole);
		comboBoxConsole.setBounds(132, 166, 152, 22);
		contentPane.add(comboBoxConsole);

		JLabel lblValorEstimado = new JLabel("Valor Estimado:");
		lblValorEstimado.setBounds(21, 206, 102, 14);
		contentPane.add(lblValorEstimado);

		txtValorEstimado = new JTextField();
		txtValorEstimado.setBounds(132, 206, 152, 20);
		contentPane.add(txtValorEstimado);
		txtValorEstimado.setColumns(10);

		JLabel lblObservação = new JLabel("Observa\u00E7\u00E3o:");
		lblObservação.setBounds(21, 237, 91, 14);
		contentPane.add(lblObservação);

		txtObservações = new JTextField();
		txtObservações.setBounds(132, 237, 152, 44);
		contentPane.add(txtObservações);
		txtObservações.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(230, 230, 250));
		btnSalvar.setForeground(new Color(0, 0, 255));
		btnSalvar.setBounds(21, 292, 138, 53);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("<");
		btnVoltar.setForeground(new Color(0, 0, 255));
		btnVoltar.setBounds(350, 307, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnAvancar = new JButton(">");
		btnAvancar.setForeground(new Color(0, 0, 255));
		btnAvancar.setBounds(458, 307, 89, 23);
		contentPane.add(btnAvancar);

		JLabel lblMeusJogos = new JLabel("Meus Jogos:");
		lblMeusJogos.setBounds(350, 51, 197, 14);
		contentPane.add(lblMeusJogos);

		JScrollPane scrollPaneJogo = new JScrollPane();
		scrollPaneJogo.setBounds(350, 65, 190, 216);
		contentPane.add(scrollPaneJogo);

		JList<String> listJogos = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listJogos.setModel(listModel);
		scrollPaneJogo.setViewportView(listJogos);

		JLabel lblTitulo = new JLabel("Cole\u00E7\u00E3o de jogos");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitulo.setBounds(230, 11, 310, 29);
		contentPane.add(lblTitulo);

		JogoRepository colecao = new JogoRepository(15);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Jogo jogo = new Jogo();
				jogo.setTitulo(txtTituloJogo.getText());
				jogo.setFabricante(fabricantes.getFabricantes(comboBoxFabricante.getSelectedIndex()));
				jogo.setValor(txtValorEstimado.getText());
				jogo.setZerado(chckbxZerado.isSelected());
				jogo.setObservacoes(txtObservações.getText());

				// Definir console
				jogo.setConsole(determinarConsole(comboBoxConsole.getSelectedIndex()));

				colecao.gravar(jogo, posicao);

				posicao++;

				// Adicionando o nome do jogo ao model da lista
				listModel.addElement(jogo.getTitulo());
				
				//Desativando o botão
				if (posicao == colecao.getTamanho()) {
					btnSalvar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "A coleção já está cheia!!", "Coleção cheia!",
							JOptionPane.WARNING_MESSAGE);
				}
				
				//Limpando os campos
				txtTituloJogo.setText("");
				txtValorEstimado.setText("");
				txtObservações.setText("");
			}
		});

		listJogos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				Jogo jogoSelecionado = colecao.listarJogo(listJogos.getSelectedIndex());
				txtTituloJogo.setText(jogoSelecionado.getTitulo());
				txtValorEstimado.setText(jogoSelecionado.getValor());
				txtObservações.setText(jogoSelecionado.getObservacoes());
				comboBoxFabricante.setSelectedIndex(fabricantes.getIndex(jogoSelecionado.getFabricante()));
				comboBoxConsole.setSelectedIndex(jogoSelecionado.getConsole().ordinal());
				chckbxZerado.setSelected(jogoSelecionado.getZerado());
			}
		});
		
		//Configurando botões avançar e voltar
		btnAvancar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Quer avançar sem nada selecionado??", "Conta outra, né?!", JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()+1);
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Quer voltar sem nada selecionado??", "Conta outra, né?!", JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()-1);
				}
			}
		});
	};

	private Console determinarConsole(int consoleSelecionado) {
		if (consoleSelecionado == 0) {
			return Console.PS;
		} else if (consoleSelecionado == 1) {
			return Console.XBOX;
		} else if (consoleSelecionado == 2) {
			return Console.NINTENDO;
		} else {
			return Console.OUTRO;
		}
	}
}
