(ns ls.core
  (:require [reagent.core :as r]
            [soda-ash.core :as sa]))

(enable-console-print!)

;; Let's see if we can trigger a proper deploy

(defn menu []
  [:div.ui.large.secondary.inverted.pointing.menu
   [:a.active.item "Home"]
   [:a.item "Not home"]
   [:a.item "Away"]
   [:div.right.item
    [:a.ui.inverted.button "Log in"]
    [:a.ui.inverted.button "Sign up"]]])

(defn main-header []
  [:div.ui.text.container
   [:h1.ui.inverted.header
    "Grunderbunder"]
   [:h2 "Et sted å grunde litt!"]
   [:div.ui.huge.primary.button "Kjør på " [:i.right.arrow.icon]]])

(defn main-content []
  [:div.ui.vertical.stripe.segment
   [:div.ui.middle.aligned.stackable.grid.container


    [:h3.ui.header "Vi kan hjelpe deg"]
    [:p "Den spesielle optiske illusjonen forekommer bare én gang i året, noen få dager i midten av februar, dersom værforholdene tillater det.\n\nPå nasjonalparkens hjemmesider kan man lese:\n\n«Horsetail Fall-fenomenet oppstår når vinkelen av solen som er i ferd med å gå ned setter fyr på fossefallet i sjatteringer av rødt og oransje, som om det er ild som faller ned El Capitan»"]
    [:h3.ui.header "Ja vi kan faktisk det"]
    [:p "Den spesielle optiske illusjonen forekommer bare én gang i året, noen få dager i midten av februar, dersom værforholdene tillater det.\n\nPå nasjonalparkens hjemmesider kan man lese:\n\n«Horsetail Fall-fenomenet oppstår når vinkelen av solen som er i ferd med å gå ned setter fyr på fossefallet i sjatteringer av rødt og oransje, som om det er ild som faller ned El Capitan»"]
    ]])

(defn more-main-content []
  [:div.ui.vertical.stripe.quote.segment
   [:div.ui.equal.width.stackable.internally.celled.grid
    [:div.center.aligned.row
     [:div.column
      [:h3 "Mye bra å si om disse folka"]
      [:p "F.eks. sa de ditt og datt, og mye annet"]]
     [:div.column
      [:h3 "Beste jeg har hatt"]
      [:p "F.eks. sa de ditt og datt, og mye annet"]]
     ]]])

(defn main []
  [:div.pusher
   [:div.ui.inverted.vertical.masthead.center.aligned.segment
    [:div.ui.container
     [menu]
     [main-header]]]
   [main-content]
   [more-main-content]])

(defn start []
  (r/render-component
    [main]
    (.getElementById js/document "app")))

(start)
