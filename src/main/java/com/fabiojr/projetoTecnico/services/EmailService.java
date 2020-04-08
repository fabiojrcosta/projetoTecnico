package com.fabiojr.projetoTecnico.services;


import org.springframework.mail.SimpleMailMessage;

import com.fabiojr.projetoTecnico.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage sm);
}