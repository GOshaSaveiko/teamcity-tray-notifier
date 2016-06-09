package jetbrains.buildServer.notification.tray.web;

import jetbrains.buildServer.notification.tray.NotifierConstants;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.SimplePageExtension;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;

/**
 * Tray notifier settings extension.
 */
public class SettingsPageExtension extends SimplePageExtension {

  private final String notifierSettingsJsp = "trayNotifierSettings.jsp";

  public SettingsPageExtension(PagePlaces pagePlaces) {
    super(pagePlaces);
    setIncludeUrl(notifierSettingsJsp);
    setPlaceId(PlaceId.NOTIFIER_SETTINGS_FRAGMENT);
    setPluginName(NotifierConstants.NOTIFIER_TYPE);
  }

  @Override
  public boolean isAvailable(@NotNull HttpServletRequest request) {
    return getPluginName().equals(request.getParameter("notificatorType"));
  }
}