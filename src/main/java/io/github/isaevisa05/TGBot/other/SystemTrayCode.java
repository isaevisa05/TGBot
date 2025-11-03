package io.github.isaevisa05.TGBot.other;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SystemTrayCode {

    public static void main(String[] args) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = img.createGraphics();
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(0, 0, 64, 64);
        graphics2D.dispose();

        TrayIcon trayIcon = new TrayIcon(img, "Уведомление");
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);

        trayIcon.displayMessage("Уведомление", "Новый пользователь  зарегистрировался", TrayIcon.MessageType.INFO);
        trayIcon.displayMessage("Уведомление", "Пользователь  авторизовался", TrayIcon.MessageType.INFO);

        tray.remove(trayIcon);
    }

}
