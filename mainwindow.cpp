#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui -> setupUi(this);

    //Configuración de los pushButtons de la ventana principal para que se pueda detectar cuando el cursos pasa sobre ellos.
    ui -> pushButtonJuego -> setAttribute(Qt::WA_Hover);
    ui -> pushButtonJuego -> installEventFilter(this);

    ui -> pushButtonLeer -> setAttribute(Qt::WA_Hover);
    ui -> pushButtonLeer -> installEventFilter(this);

    ui -> pushButtonAcerca -> setAttribute(Qt::WA_Hover);
    ui -> pushButtonAcerca -> installEventFilter(this);

    ui -> pushButtonSalir -> setAttribute(Qt::WA_Hover);
    ui -> pushButtonSalir -> installEventFilter(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

//Método que define las reacciones a ejecutar cuando se pasa por encima de alguno de los botones de la ventana.
//Según sea el botón sobre el que se está pasando, un mensaje distinto se muestra en label2.
bool MainWindow::eventFilter(QObject* obj, QEvent *event)
{
    if (obj == ui -> pushButtonJuego) {
        if (event -> type() == QEvent::Enter) {
            ui -> label2 ->setText("En esta modalidad puedes aprender sobre el balanceo de ABBs de forma interactiva :D");
            return true;
        } else if (event -> type() == QEvent::Leave) {
            ui -> label2 -> setText("");
            return true;
        }
    } else if (obj == ui -> pushButtonLeer) {
        if (event -> type() == QEvent::Enter) {
            ui -> label2 ->setText("Aquí puedes leer sobre los árboles binarios de búsqueda y su balanceo :)");
            return true;
        } else if (event -> type() == QEvent::Leave) {
            ui -> label2 -> setText("");
            return true;
        }
    } else if (obj == ui -> pushButtonAcerca) {
        if (event -> type() == QEvent::Enter) {
            ui -> label2 ->setText("Da clic aquí si quieres aprender más sobre TreeBalance.");
            return true;
        } else if (event -> type() == QEvent::Leave) {
            ui -> label2 -> setText("");
            return true;
        }
    } else if (obj == ui -> pushButtonSalir) {
        if (event -> type() == QEvent::Enter) {
            ui -> label2 ->setText("¿Ya te vas? :(");
            return true;
        } else if (event -> type() == QEvent::Leave) {
            ui -> label2 -> setText("");
            return true;
        }
    }
    return QMainWindow::eventFilter(obj, event);
}
