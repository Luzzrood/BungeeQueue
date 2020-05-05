package fr.maxlego08.bungeequeue.utils;

import fr.maxlego08.bungeequeue.utils.enums.LogType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;

public class Logger {

	private final String prefix;
	private static Logger logger;

	public Logger(String prefix) {
		this.prefix = prefix;
		logger = this;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void info(String message, LogType type) {
		getLogger().log(message, type);
	}

	public static void info(String message) {
		getLogger().log(message, LogType.INFO);
	}

	public String getPrefix() {
		return prefix;
	}

	public void log(String message, LogType type) {
		ProxyServer.getInstance().getConsole().sendMessage(
				new TextComponent("�8[�e" + prefix + "�8] " + type.getColor() + getColoredMessage(message)));
	}

	public void log(String message) {
		ProxyServer.getInstance().getConsole()
				.sendMessage(new TextComponent("�8[�e" + prefix + "�8] �e" + getColoredMessage(message)));
	}

	public void log(String message, Object... args) {
		log(String.format(message, args));
	}

	public void log(String message, LogType type, Object... args) {
		log(String.format(message, args), type);
	}

	public void log(String[] messages, LogType type) {
		for (String message : messages) {
			log(message, type);
		}
	}

	public String getColoredMessage(String message) {
		return message.replace("<&>", "�");
	}
}