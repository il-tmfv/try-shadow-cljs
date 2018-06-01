(ns my.routes
  (:import goog.History)
  (:require [secretary.core :as secretary :refer-macros [defroute]]
            [accountant.core :as accountant]
            [goog.events :as events]
            [re-frame.core :as re]
            [my.about :refer [about-page]]
            [goog.history.EventType :as HistoryEventType]))

(defroute "/" []
  (re/dispatch [:navigate :welcome]))

(defroute "/about" []
  (re/dispatch [:navigate :about]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     HistoryEventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn init-accountant! []
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (secretary/dispatch! path))
    :path-exists?
    (fn [path]
      (secretary/locate-route path))})
  (hook-browser-navigation!)
  (accountant/dispatch-current!))
