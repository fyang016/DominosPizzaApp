package com.os.operando.emptyactivity;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
/**
 * Created by Se Hoon Bang on 11/14/2017.
 */

public class ToppingChoice extends AppCompatActivity {
    EditText txtSauce, txtQuantity, txtCheese, txtPepperoni, txtSausage, txtBeef,
            txtSteak, txtHam, txtBacon, txtSalami, txtChicken, txtCheddar, txtFeta,
            txtParmesan, txtProvolone, txtBanana, txtOlives, txtGreen, txtJalapeno,
            txtMushrooms, txtPineapple, txtOnions, txtRoast,txtSpinach, txtDiced, txtHot;

    Button btnQuantity, btnSauce, btnCheese, btnPepperoni, btnSausage, btnBeef, btnSteak,
            btnHam, btnBacon, btnSalami, btnChicken, btnCheddar, btnFeta, btnParmesan,
            btnProvolone, btnBanana, btnOlives, btnGreen, btnJalapeno, btnMushrooms,
            btnPineapple, btnOnions, btnRoast, btnSpinach, btnDiced, btnHot;

    int quantityCount = 1;

    int sauceDensity, cheeseDensity = 2;

    int pepperoniDensity, sausageDensity,beefDensity, baconDensity, steakDensity,
            hamDensity, salamiDensity, chickenDensity, cheddarDensity, fetaDensity,
            parmesanDensity, bananaDensity, olivesDensity, greenDensity, jalapenoDensity,
            mushroomsDensity, pineappleDensity, onionDensity, roastDensity,
            provoloneDensity,spinachDensity, dicedDensity, hotDensity= 0;

    String[] density = new String[] { "None", "Light", "Normal", "Extra", "Double"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping_choice);

        //Spinner 1
        //get the spinner from the xml.
        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] items = new String[]{"Hand Tossed - Small (10\")",
                "Hand Tossed - Medium (12\") ","Hand Tossed - Large (14\") ",
                "Handmade Pan - Small (10\")", "Handmade Pan - Medium (12\")",
                "Handmade Pan - Large (14\")", "Crunchy Thin Crust - Small(10\')",
                "Crunchy Thin Crust - Medium(12\')", "Crunchy Thin Crust - Large(14\')",
                "Brooklyn Style - Small (10\")", "Brooklyn Style - Medium (12\")",
                "Brooklyn Style - Large (14\")", "Gluten Free Crust -Small (10\')",
                "Gluten Free Crust -Medium (12\')", "Gluten Free Crust -Large (14\')",};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        //Spinner 2
        //get the spinner from the xml.
        Spinner dropdown2 = (Spinner)findViewById(R.id.spinnerSauce);
        //create a list of items for the spinner.
        String[] items2 = new String[]{ "Robust Inspired Tomato Sauce", "No Sauce",
                "BBQ Sauce", "Garlic Parmesan White Sauce", "Alfredo Sauce"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items2);
        //set the spinners adapter to the previously created one.
        dropdown2.setAdapter(adapter2);

        //Spinner Seasoning
        //get the spinner from the xml.
        Spinner dropdown3 = (Spinner)findViewById(R.id.spinnerSeasoning);
        //create a list of items for the spinner.
        String[] items3 = new String[]{ "Garlic-Seasoned Crust", "No Garlic-Seasoned Crust"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items3);
        //set the spinners adapter to the previously created one.
        dropdown3.setAdapter(adapter3);

        //Spinner Cut
        //get the spinner from the xml.
        Spinner dropdown4 = (Spinner)findViewById(R.id.spinnerCut);
        //create a list of items for the spinner.
        String[] items4 = new String[]{ "Pie Cut", "Square Cut", "Uncut"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items4);
        //set the spinners adapter to the previously created one.
        dropdown4.setAdapter(adapter4);

        //Spinner Bake
        //get the spinner from the xml.
        Spinner dropdown5 = (Spinner)findViewById(R.id.spinnerBake);
        //create a list of items for the spinner.
        String[] items5 = new String[]{ "Well Done", "Normal Bake"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items5);
        //set the spinners adapter to the previously created one.
        dropdown5.setAdapter(adapter5);

        //Quality buttons
        //Plus
        txtQuantity = (EditText) findViewById(R.id.editText1);
        txtQuantity.setText(String.valueOf(quantityCount));
        btnQuantity = (Button)findViewById(R.id.plus1);

        btnQuantity.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               quantityCount++;
                                               txtQuantity.setText(String.valueOf(quantityCount));
                                           }
                                       }
        );

        //Minus
        txtQuantity = (EditText)findViewById(R.id.editText1);
        txtQuantity.setText(String.valueOf(quantityCount));
        btnQuantity = (Button)findViewById(R.id.minus1);

        btnQuantity.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               if ( quantityCount > 1) {
                                                   quantityCount--;
                                               }
                                               txtQuantity.setText(String.valueOf(quantityCount));
                                           }
                                       }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Sauce buttons
        //Plus
        txtSauce = (EditText)findViewById(R.id.textSauce2);
        txtSauce.setText(String.valueOf(density[sauceDensity]));
        btnSauce = (Button)findViewById(R.id.plus2);

        btnSauce.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(sauceDensity < 4) {
                                                sauceDensity++;
                                            }
                                            txtSauce.setText(String.valueOf(density[sauceDensity]));
                                        }
                                    }
        );

        //Minus
        txtSauce = (EditText)findViewById(R.id.textSauce2);
        txtSauce.setText(String.valueOf(density[sauceDensity]));
        btnSauce = (Button)findViewById(R.id.minus2);

        btnSauce.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( sauceDensity > 0) {
                                                sauceDensity--;
                                            }
                                            txtSauce.setText(String.valueOf(density[sauceDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        //Cheese buttons
        //Plus
        txtCheese = (EditText)findViewById(R.id.textCheese2);
        txtCheese.setText(String.valueOf(density[cheeseDensity]));
        btnCheese = (Button)findViewById(R.id.plus3);

        btnCheese.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if(cheeseDensity < 4) {
                                                 cheeseDensity++;
                                             }
                                             txtCheese.setText(String.valueOf(density[cheeseDensity]));
                                         }
                                     }
        );

        //Minus
        txtCheese = (EditText)findViewById(R.id.textCheese2);
        txtCheese.setText(String.valueOf(density[cheeseDensity]));
        btnCheese = (Button)findViewById(R.id.minus3);

        btnCheese.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if ( cheeseDensity > 0) {
                                                 cheeseDensity--;
                                             }
                                             txtCheese.setText(String.valueOf(density[cheeseDensity]));
                                         }
                                     }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        //Pepperoni buttons
        //Plus
        txtPepperoni = (EditText)findViewById(R.id.textPepperoni2);
        txtPepperoni.setText(String.valueOf(density[pepperoniDensity]));
        btnPepperoni = (Button)findViewById(R.id.plus4);

        btnPepperoni.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if(pepperoniDensity < 4) {
                                                    pepperoniDensity++;
                                                }
                                                txtPepperoni.setText(String.valueOf(density[pepperoniDensity]));
                                            }
                                        }
        );

        //Minus
        txtPepperoni = (EditText)findViewById(R.id.textPepperoni2);
        txtPepperoni.setText(String.valueOf(density[pepperoniDensity]));
        btnPepperoni = (Button)findViewById(R.id.minus4);

        btnPepperoni.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if ( pepperoniDensity > 0) {
                                                    pepperoniDensity--;
                                                }
                                                txtPepperoni.setText(String.valueOf(density[pepperoniDensity]));
                                            }
                                        }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Italian Sausage buttons
        //Plus
        txtSausage = (EditText)findViewById(R.id.textSausage2);
        txtSausage.setText(String.valueOf(density[sausageDensity]));
        btnSausage = (Button)findViewById(R.id.plus5);

        btnSausage.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if(sausageDensity < 4) {
                                                  sausageDensity++;
                                              }
                                              txtSausage.setText(String.valueOf(density[sausageDensity]));
                                          }
                                      }
        );

        //Minus
        txtSausage = (EditText)findViewById(R.id.textSausage2);
        txtSausage.setText(String.valueOf(density[sausageDensity]));
        btnSausage = (Button)findViewById(R.id.minus5);

        btnSausage.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if ( sausageDensity > 0) {
                                                  sausageDensity--;
                                              }
                                              txtSausage.setText(String.valueOf(density[sausageDensity]));
                                          }
                                      }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        //Beef buttons
        //Plus
        txtBeef = (EditText)findViewById(R.id.textBeef2);
        txtBeef.setText(String.valueOf(density[beefDensity]));
        btnBeef = (Button)findViewById(R.id.plus6);

        btnBeef.setOnClickListener(new OnClickListener() {
                                       public void onClick(View arg0) {
                                           if(beefDensity < 4) {
                                               beefDensity++;
                                           }
                                           txtBeef.setText(String.valueOf(density[beefDensity]));
                                       }
                                   }
        );

        //Minus
        txtBeef = (EditText)findViewById(R.id.textBeef2);
        txtBeef.setText(String.valueOf(density[beefDensity]));
        btnBeef = (Button)findViewById(R.id.minus6);

        btnBeef.setOnClickListener(new OnClickListener() {
                                       public void onClick(View arg0) {
                                           if ( beefDensity > 0) {
                                               beefDensity--;
                                           }
                                           txtBeef.setText(String.valueOf(density[beefDensity]));
                                       }
                                   }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        //Philly Steak buttons
        //Plus
        txtSteak = (EditText)findViewById(R.id.textSteak2);
        txtSteak.setText(String.valueOf(density[steakDensity]));
        btnSteak = (Button)findViewById(R.id.plus7);

        btnSteak.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(steakDensity < 4) {
                                                steakDensity++;
                                            }
                                            txtSteak.setText(String.valueOf(density[steakDensity]));
                                        }
                                    }
        );

        //Minus
        txtSteak = (EditText)findViewById(R.id.textSteak2);
        txtSteak.setText(String.valueOf(density[steakDensity]));
        btnSteak = (Button)findViewById(R.id.minus7);

        btnSteak.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( steakDensity > 0) {
                                                steakDensity--;
                                            }
                                            txtSteak.setText(String.valueOf(density[steakDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Ham buttons
        //Plus
        txtHam = (EditText)findViewById(R.id.textHam2);
        txtHam.setText(String.valueOf(density[hamDensity]));
        btnHam = (Button)findViewById(R.id.plus8);

        btnHam.setOnClickListener(new OnClickListener() {
                                      public void onClick(View arg0) {
                                          if(hamDensity < 4) {
                                              hamDensity++;
                                          }
                                          txtHam.setText(String.valueOf(density[hamDensity]));
                                      }
                                  }
        );

        //Minus
        txtHam = (EditText)findViewById(R.id.textHam2);
        txtHam.setText(String.valueOf(density[hamDensity]));
        btnHam = (Button)findViewById(R.id.minus8);

        btnHam.setOnClickListener(new OnClickListener() {
                                      public void onClick(View arg0) {
                                          if ( hamDensity > 0) {
                                              hamDensity--;
                                          }
                                          txtHam.setText(String.valueOf(density[hamDensity]));
                                      }
                                  }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Bacon buttons
        //Plus
        txtBacon = (EditText)findViewById(R.id.textBacon2);
        txtBacon.setText(String.valueOf(density[baconDensity]));
        btnBacon = (Button)findViewById(R.id.plus9);

        btnBacon.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(baconDensity < 4) {
                                                baconDensity++;
                                            }
                                            txtBacon.setText(String.valueOf(density[baconDensity]));
                                        }
                                    }
        );

        //Minus
        txtBacon = (EditText)findViewById(R.id.textBacon2);
        txtBacon.setText(String.valueOf(density[baconDensity]));
        btnBacon = (Button)findViewById(R.id.minus9);

        btnBacon.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( baconDensity > 0) {
                                                baconDensity--;
                                            }
                                            txtBacon.setText(String.valueOf(density[baconDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Salami buttons
        //Plus
        txtSalami = (EditText)findViewById(R.id.textSalami2);
        txtSalami.setText(String.valueOf(density[salamiDensity]));
        btnSalami = (Button)findViewById(R.id.plus10);

        btnSalami.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if(salamiDensity < 4) {
                                                 salamiDensity++;
                                             }
                                             txtSalami.setText(String.valueOf(density[salamiDensity]));
                                         }
                                     }
        );

        //Minus
        txtSalami = (EditText)findViewById(R.id.textSalami2);
        txtSalami.setText(String.valueOf(density[salamiDensity]));
        btnSalami = (Button)findViewById(R.id.minus10);

        btnSalami.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if ( salamiDensity > 0) {
                                                 salamiDensity--;
                                             }
                                             txtSalami.setText(String.valueOf(density[salamiDensity]));
                                         }
                                     }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Premium Chicken buttons
        //Plus
        txtChicken = (EditText)findViewById(R.id.textChicken2);
        txtChicken.setText(String.valueOf(density[chickenDensity]));
        btnChicken = (Button)findViewById(R.id.plus11);

        btnChicken.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if(chickenDensity < 4) {
                                                  chickenDensity++;
                                              }
                                              txtChicken.setText(String.valueOf(density[chickenDensity]));
                                          }
                                      }
        );

        //Minus
        txtChicken = (EditText)findViewById(R.id.textChicken2);
        txtChicken.setText(String.valueOf(density[chickenDensity]));
        btnChicken = (Button)findViewById(R.id.minus11);

        btnChicken.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if ( chickenDensity > 0) {
                                                  chickenDensity--;
                                              }
                                              txtChicken.setText(String.valueOf(density[chickenDensity]));
                                          }
                                      }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Cheddar Cheese buttons
        //Plus
        txtCheddar = (EditText)findViewById(R.id.textCheddar2);
        txtCheddar.setText(String.valueOf(density[cheddarDensity]));
        btnCheddar = (Button)findViewById(R.id.plus12);

        btnCheddar.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if(cheddarDensity < 4) {
                                                  cheddarDensity++;
                                              }
                                              txtCheddar.setText(String.valueOf(density[cheddarDensity]));
                                          }
                                      }
        );

        //Minus
        txtCheddar = (EditText)findViewById(R.id.textCheddar2);
        txtCheddar.setText(String.valueOf(density[cheddarDensity]));
        btnCheddar = (Button)findViewById(R.id.minus12);

        btnCheddar.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if ( cheddarDensity > 0) {
                                                  cheddarDensity--;
                                              }
                                              txtCheddar.setText(String.valueOf(density[cheddarDensity]));
                                          }
                                      }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Feta Cheese buttons
        //Plus
        txtFeta = (EditText)findViewById(R.id.textFeta2);
        txtFeta.setText(String.valueOf(density[fetaDensity]));
        btnFeta = (Button)findViewById(R.id.plus13);

        btnFeta.setOnClickListener(new OnClickListener() {
                                       public void onClick(View arg0) {
                                           if(fetaDensity < 4) {
                                               fetaDensity++;
                                           }
                                           txtFeta.setText(String.valueOf(density[fetaDensity]));
                                       }
                                   }
        );

        //Minus
        txtFeta = (EditText)findViewById(R.id.textFeta2);
        txtFeta.setText(String.valueOf(density[fetaDensity]));
        btnFeta = (Button)findViewById(R.id.minus13);

        btnFeta.setOnClickListener(new OnClickListener() {
                                       public void onClick(View arg0) {
                                           if ( fetaDensity > 0) {
                                               fetaDensity--;
                                           }
                                           txtFeta.setText(String.valueOf(density[fetaDensity]));
                                       }
                                   }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Shredded Parmesan Asiago buttons
        //Plus
        txtParmesan = (EditText)findViewById(R.id.textParmesan2);
        txtParmesan.setText(String.valueOf(density[parmesanDensity]));
        btnParmesan = (Button)findViewById(R.id.plus14);

        btnParmesan.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               if(parmesanDensity < 4) {
                                                   parmesanDensity++;
                                               }
                                               txtParmesan.setText(String.valueOf(density[parmesanDensity]));
                                           }
                                       }
        );

        //Minus
        txtParmesan = (EditText)findViewById(R.id.textParmesan2);
        txtParmesan.setText(String.valueOf(density[parmesanDensity]));
        btnParmesan = (Button)findViewById(R.id.minus14);

        btnParmesan.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               if ( parmesanDensity > 0) {
                                                   parmesanDensity--;
                                               }
                                               txtParmesan.setText(String.valueOf(density[parmesanDensity]));
                                           }
                                       }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        //Shredded Provolone Cheese buttons
        //Plus
        txtProvolone = (EditText)findViewById(R.id.textProvolone2);
        txtProvolone.setText(String.valueOf(density[provoloneDensity]));
        btnProvolone = (Button)findViewById(R.id.plus15);

        btnProvolone.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if(provoloneDensity < 4) {
                                                    provoloneDensity++;
                                                }
                                                txtProvolone.setText(String.valueOf(density[provoloneDensity]));
                                            }
                                        }
        );

        //Minus
        txtProvolone = (EditText)findViewById(R.id.textProvolone2);
        txtProvolone.setText(String.valueOf(density[provoloneDensity]));
        btnProvolone = (Button)findViewById(R.id.minus15);

        btnProvolone.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if ( provoloneDensity > 0) {
                                                    provoloneDensity--;
                                                }
                                                txtProvolone.setText(String.valueOf(density[provoloneDensity]));
                                            }
                                        }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Banana Peppers buttons
        //Plus
        txtBanana = (EditText)findViewById(R.id.textBanana2);
        txtBanana.setText(String.valueOf(density[bananaDensity]));
        btnBanana = (Button)findViewById(R.id.plus16);

        btnBanana.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if(bananaDensity < 4) {
                                                 bananaDensity++;
                                             }
                                             txtBanana.setText(String.valueOf(density[bananaDensity]));
                                         }
                                     }
        );

        //Minus
        txtBanana = (EditText)findViewById(R.id.textBanana2);
        txtBanana.setText(String.valueOf(density[bananaDensity]));
        btnBanana = (Button)findViewById(R.id.minus16);

        btnBanana.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if ( bananaDensity > 0) {
                                                 bananaDensity--;
                                             }
                                             txtBanana.setText(String.valueOf(density[bananaDensity]));
                                         }
                                     }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Black Olives buttons
        //Plus
        txtOlives = (EditText)findViewById(R.id.textOlives2);
        txtOlives.setText(String.valueOf(density[olivesDensity]));
        btnOlives = (Button)findViewById(R.id.plus17);

        btnOlives.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if(olivesDensity < 4) {
                                                 olivesDensity++;
                                             }
                                             txtOlives.setText(String.valueOf(density[olivesDensity]));
                                         }
                                     }
        );

        //Minus
        txtOlives = (EditText)findViewById(R.id.textOlives2);
        txtOlives.setText(String.valueOf(density[olivesDensity]));
        btnOlives = (Button)findViewById(R.id.minus17);

        btnOlives.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if ( olivesDensity > 0) {
                                                 olivesDensity--;
                                             }
                                             txtOlives.setText(String.valueOf(density[olivesDensity]));
                                         }
                                     }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Green Peppers buttons
        //Plus
        txtGreen = (EditText)findViewById(R.id.textGreen2);
        txtGreen.setText(String.valueOf(density[greenDensity]));
        btnGreen = (Button)findViewById(R.id.plus18);

        btnGreen.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(greenDensity < 4) {
                                                greenDensity++;
                                            }
                                            txtGreen.setText(String.valueOf(density[greenDensity]));
                                        }
                                    }
        );

        //Minus
        txtGreen = (EditText)findViewById(R.id.textGreen2);
        txtGreen.setText(String.valueOf(density[greenDensity]));
        btnGreen = (Button)findViewById(R.id.minus18);

        btnGreen.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( greenDensity > 0) {
                                                greenDensity--;
                                            }
                                            txtGreen.setText(String.valueOf(density[greenDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Jalapeno Peppers buttons
        //Plus
        txtJalapeno = (EditText)findViewById(R.id.textJalapeno2);
        txtJalapeno.setText(String.valueOf(density[jalapenoDensity]));
        btnJalapeno = (Button)findViewById(R.id.plus19);

        btnJalapeno.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               if(jalapenoDensity < 4) {
                                                   jalapenoDensity++;
                                               }
                                               txtJalapeno.setText(String.valueOf(density[jalapenoDensity]));
                                           }
                                       }
        );

        //Minus
        txtJalapeno = (EditText)findViewById(R.id.textJalapeno2);
        txtJalapeno.setText(String.valueOf(density[jalapenoDensity]));
        btnJalapeno = (Button)findViewById(R.id.minus19);

        btnJalapeno.setOnClickListener(new OnClickListener() {
                                           public void onClick(View arg0) {
                                               if ( jalapenoDensity > 0) {
                                                   jalapenoDensity--;
                                               }
                                               txtJalapeno.setText(String.valueOf(density[jalapenoDensity]));
                                           }
                                       }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Mushrooms buttons
        //Plus
        txtMushrooms = (EditText)findViewById(R.id.textMushrooms2);
        txtMushrooms.setText(String.valueOf(density[mushroomsDensity]));
        btnMushrooms = (Button)findViewById(R.id.plus20);

        btnMushrooms.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if(mushroomsDensity < 4) {
                                                    mushroomsDensity++;
                                                }
                                                txtMushrooms.setText(String.valueOf(density[mushroomsDensity]));
                                            }
                                        }
        );

        //Minus
        txtMushrooms = (EditText)findViewById(R.id.textMushrooms2);
        txtMushrooms.setText(String.valueOf(density[mushroomsDensity]));
        btnMushrooms = (Button)findViewById(R.id.minus20);

        btnMushrooms.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if ( mushroomsDensity > 0) {
                                                    mushroomsDensity--;
                                                }
                                                txtMushrooms.setText(String.valueOf(density[mushroomsDensity]));
                                            }
                                        }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Pineapple buttons
        //Plus
        txtPineapple = (EditText)findViewById(R.id.textPineapple2);
        txtPineapple.setText(String.valueOf(density[pineappleDensity]));
        btnPineapple = (Button)findViewById(R.id.plus21);

        btnPineapple.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if(pineappleDensity < 4) {
                                                    pineappleDensity++;
                                                }
                                                txtPineapple.setText(String.valueOf(density[pineappleDensity]));
                                            }
                                        }
        );

        //Minus
        txtPineapple = (EditText)findViewById(R.id.textPineapple2);
        txtPineapple.setText(String.valueOf(density[pineappleDensity]));
        btnPineapple = (Button)findViewById(R.id.minus21);

        btnPineapple.setOnClickListener(new OnClickListener() {
                                            public void onClick(View arg0) {
                                                if ( pineappleDensity > 0) {
                                                    pineappleDensity--;
                                                }
                                                txtPineapple.setText(String.valueOf(density[pineappleDensity]));
                                            }
                                        }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Onions buttons
        //Plus
        txtOnions = (EditText)findViewById(R.id.textOnion2);
        txtOnions.setText(String.valueOf(density[onionDensity]));
        btnOnions = (Button)findViewById(R.id.plusO);

        btnOnions.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if(onionDensity < 4) {
                                                 onionDensity++;
                                             }
                                             txtOnions.setText(String.valueOf(density[onionDensity]));
                                         }
                                     }
        );

        //Minus
        txtOnions = (EditText)findViewById(R.id.textOnion2);
        txtOnions.setText(String.valueOf(density[onionDensity]));
        btnOnions = (Button)findViewById(R.id.minusO);

        btnOnions.setOnClickListener(new OnClickListener() {
                                         public void onClick(View arg0) {
                                             if ( onionDensity > 0) {
                                                 onionDensity--;
                                             }
                                             txtOnions.setText(String.valueOf(density[onionDensity]));
                                         }
                                     }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Roasted Red Peppers buttons
        //Plus
        txtRoast = (EditText)findViewById(R.id.textRoastR2);
        txtRoast.setText(String.valueOf(density[roastDensity]));
        btnRoast = (Button)findViewById(R.id.plus22);

        btnRoast.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(roastDensity < 4) {
                                                roastDensity++;
                                            }
                                            txtRoast.setText(String.valueOf(density[roastDensity]));
                                        }
                                    }
        );

        //Minus
        txtRoast = (EditText)findViewById(R.id.textRoastR2);
        txtRoast.setText(String.valueOf(density[roastDensity]));
        btnRoast = (Button)findViewById(R.id.minus22);

        btnRoast.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( roastDensity > 0) {
                                                roastDensity--;
                                            }
                                            txtRoast.setText(String.valueOf(density[roastDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Spinach buttons
        //Plus
        txtSpinach = (EditText)findViewById(R.id.textSpinach2);
        txtSpinach.setText(String.valueOf(density[spinachDensity]));
        btnSpinach = (Button)findViewById(R.id.plus23);

        btnSpinach.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if(spinachDensity < 4) {
                                                  spinachDensity++;
                                              }
                                              txtSpinach.setText(String.valueOf(density[spinachDensity]));
                                          }
                                      }
        );

        //Minus
        txtSpinach = (EditText)findViewById(R.id.textSpinach2);
        txtSpinach.setText(String.valueOf(density[spinachDensity]));
        btnSpinach = (Button)findViewById(R.id.minus23);

        btnSpinach.setOnClickListener(new OnClickListener() {
                                          public void onClick(View arg0) {
                                              if ( spinachDensity > 0) {
                                                  spinachDensity--;
                                              }
                                              txtSpinach.setText(String.valueOf(density[spinachDensity]));
                                          }
                                      }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Diced Tomatoes buttons
        //Plus
        txtDiced = (EditText)findViewById(R.id.textDtomatoes2);
        txtDiced.setText(String.valueOf(density[dicedDensity]));
        btnDiced = (Button)findViewById(R.id.plus24);

        btnDiced.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if(dicedDensity < 4) {
                                                dicedDensity++;
                                            }
                                            txtDiced.setText(String.valueOf(density[dicedDensity]));
                                        }
                                    }
        );

        //Minus
        txtDiced = (EditText)findViewById(R.id.textDtomatoes2);
        txtDiced.setText(String.valueOf(density[dicedDensity]));
        btnDiced = (Button)findViewById(R.id.minus24);

        btnDiced.setOnClickListener(new OnClickListener() {
                                        public void onClick(View arg0) {
                                            if ( dicedDensity > 0) {
                                                dicedDensity--;
                                            }
                                            txtDiced.setText(String.valueOf(density[dicedDensity]));
                                        }
                                    }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Hot Sauce buttons
        //Plus
        txtHot = (EditText)findViewById(R.id.textHsauce2);
        txtHot.setText(String.valueOf(density[hotDensity]));
        btnHot = (Button)findViewById(R.id.plus25);

        btnHot.setOnClickListener(new OnClickListener() {
                                      public void onClick(View arg0) {
                                          if(hotDensity < 4) {
                                              hotDensity++;
                                          }
                                          txtHot.setText(String.valueOf(density[hotDensity]));
                                      }
                                  }
        );

        //Minus
        txtHot = (EditText)findViewById(R.id.textHsauce2);
        txtHot.setText(String.valueOf(density[hotDensity]));
        btnHot = (Button)findViewById(R.id.minus25);

        btnHot.setOnClickListener(new OnClickListener() {
                                      public void onClick(View arg0) {
                                          if ( hotDensity > 0) {
                                              hotDensity--;
                                          }
                                          txtHot.setText(String.valueOf(density[hotDensity]));
                                      }
                                  }
        );
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




    }
    public void gotots(View view)
    {
        startActivity(new Intent(getApplicationContext(),ToppingChoice.class));
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
